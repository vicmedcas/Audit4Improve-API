/**
 * 
 */
package us.muit.fs.a4i.model.daos;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GHRepositoryStatistics;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GHRepositoryStatistics.CodeFrequency;

import us.muit.fs.a4i.model.entities.Metric;
import us.muit.fs.a4i.model.entities.Metric.MetricBuilder;

import us.muit.fs.a4i.model.entities.RepositoryReport;

/**
 * @author Isabel Román
 *
 */
public class GHRepositoryReportBuilder extends GHBuilder<RepositoryReport> {
	private static Logger log=Logger.getLogger(GHRepositoryReportBuilder.class.getName());
	/**
	 * <p>Información sobre el repositorio obtenida de GitHub</p>
	 */
	private GHRepository remoteRepo;
	/**
	 * <p>Entidad local, con la información de interés. Puede incluir información directa o calculada</p>
	 * <p>La versión actual incluye información obtenida de una única consulta<p>
	 */
	private RepositoryReport myRepo;
	
	public GHRepositoryReportBuilder(String id) {
		super(id);		
	}
	
	public GHRepositoryReportBuilder() {
		super();	
	}

	@Override
	public RepositoryReport construyeObjeto() {
		log.info("Invocado el método que construye un objeto RepositoryReport");
		/**
		 * <p>En estos momentos cada vez que se invoca construyeObjeto se rellena de nuevo</p>
		 * <p>Deuda técnica: se puede optimizar consultando sólo las diferencias respecto a la fecha de la última representación local</p>
		 */
	        
			if(entityId!=null) {
				try {
					log.info("Nombre repo = "+entityId);
					
					GitHub gb=getConnection();
					remoteRepo=gb.getRepository(entityId);
					log.info("leído "+remoteRepo);
					myRepo=new RepositoryReport(entityId);
					
					/**
					 * Métricas directas de tipo conteo
					 */
					
					MetricBuilder<Integer> subscribers= new Metric.MetricBuilder<Integer>("subscribers",remoteRepo.getSubscribersCount());
					subscribers.description("Número de suscriptores, watchers en la web").unit("subscribers").source("GitHub");
				    myRepo.addCountMetric(subscribers.build());
				    log.info("Añadida métrica suscriptores "+subscribers);
				    
				    MetricBuilder<Integer> forks=new Metric.MetricBuilder<Integer>("forks", remoteRepo.getForksCount());
				    forks.description("Número de forks, no son los foks de la web").source("GitHub");
				    myRepo.addCountMetric(forks.build());
				    log.info("Añadida métrica forks "+forks);
				    
				    MetricBuilder<Integer> watchers=new Metric.MetricBuilder<Integer>("watchers",remoteRepo.getWatchersCount());
				    watchers.description("Observadores, en la web aparece com forks").source("GitHub");
				    myRepo.addCountMetric(watchers.build());
				    
				    MetricBuilder<Integer> stars=new Metric.MetricBuilder<Integer>("stars",remoteRepo.getStargazersCount());
				    stars.description("Estrellas otorgadas").source("GitHub");
				    myRepo.addCountMetric(stars.build());
				    
				    MetricBuilder<Integer> issues=new Metric.MetricBuilder<Integer>("issues", remoteRepo.getOpenIssueCount());
				    issues.source("GitHub").description("Número de tareas sin cerrar");
					myRepo.addCountMetric(issues.build());
					/**
					 * Métricas directas de tipo fecha
					 */
					
					MetricBuilder<Date> creation=new Metric.MetricBuilder<Date>("creation", remoteRepo.getCreatedAt());
					creation.source("GitHub").description("Fecha de creación del repositorio");
					myRepo.addRelevantDate(creation.build());
					
					MetricBuilder<Date> push=new Metric.MetricBuilder<Date>("lastPush", remoteRepo.getPushedAt());
					push.description("Último push realizado en el repositorio").source("GitHub");
					myRepo.addRelevantDate(push.build());
					
					MetricBuilder<Date> updated=new Metric.MetricBuilder<Date>("lastUpdated", remoteRepo.getUpdatedAt());
					push.description("Última actualización").source("GitHub");
					myRepo.addRelevantDate(updated.build());
					/**
					 * Métricas más elaboradas, requieren más "esfuerzo"
					 */
					
					GHRepositoryStatistics data=remoteRepo.getStatistics();
					List<CodeFrequency> codeFreq=data.getCodeFrequency();
					int additions=0;
					int deletions=0;
					for(CodeFrequency freq:codeFreq) {
						
						if((freq.getAdditions()!= 0) || (freq.getDeletions()!=0)) {
						    Date fecha=new Date((long)freq.getWeekTimestamp()*1000);
						    log.info("Fecha modificaciones "+fecha);
						    additions+=freq.getAdditions();
							deletions+=freq.getDeletions();
						}
						
					}
					MetricBuilder<Integer> totalAdditions=new Metric.MetricBuilder<Integer>("additions", additions);
				    totalAdditions.source("GitHub, calculada").description("Suma el total de adiciones desde que el repositorio se creó");
				    myRepo.addCountMetric(totalAdditions.build());
				    
				    MetricBuilder<Integer> totalDeletions=new Metric.MetricBuilder<Integer>("deletions", deletions);
				    totalDeletions.source("GitHub, calculada").description("Suma el total de borrados desde que el repositorio se creó");
				    myRepo.addCountMetric(totalDeletions.build());		
				
					
				}catch(Exception e){
					log.severe("Problemas en la conexión "+e);
				}
			}
			
			return myRepo;
		}


}

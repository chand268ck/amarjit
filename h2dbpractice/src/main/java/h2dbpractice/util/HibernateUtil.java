package h2dbpractice.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

	private static StandardServiceRegistry registery;
	private static SessionFactory factory;
	 public static SessionFactory getSessionFactory() {
	        if (factory == null) {
	            try {
	                // Create registry
	            	registery = new StandardServiceRegistryBuilder().configure().build();

	                // Create MetadataSources
	                MetadataSources sources = new MetadataSources(registery);

	                // Create Metadata
	                Metadata metadata = sources.getMetadataBuilder().build();

	                // Create SessionFactory
	                factory = metadata.getSessionFactoryBuilder().build();

	            } catch (Exception e) {
	                e.printStackTrace();
	                if (registery != null) {
	                    StandardServiceRegistryBuilder.destroy(registery);
	                }
	            }
	        }
	        return factory;
	    }
	 
	 public static void shutdown() {
	        if (registery != null) {
	            StandardServiceRegistryBuilder.destroy(registery);
	        }
	    }

}

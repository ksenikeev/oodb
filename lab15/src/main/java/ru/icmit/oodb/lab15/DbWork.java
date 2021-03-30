package ru.icmit.oodb.lab15;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.*;

public class DbWork {

	private  static EntityManagerFactory emf;
	private  static volatile DbWork db = null;
	private  Map<Long, EntityManager> mapEntityManager= new HashMap<>();

	public static DbWork getInstance() {
		DbWork localInstance = db;
		if (localInstance == null) {
			synchronized(DbWork.class) {
				localInstance = db;
				if (localInstance == null) {
					emf = getEmfFactory();
					db = localInstance = new DbWork();
				}
			}
		}
		return db;
	}
	
	public static void clear(){
		db.closeEntityManager();
		emf.close();
		emf = null;
		db = null;
	}

	private static EntityManagerFactory getEmfFactory() {
        if (emf == null) {
			emf = Persistence.createEntityManagerFactory("lab15");
        }
        return emf;
	}

	public EntityManager getEmManager(){
		synchronized(mapEntityManager){
			Long key =  Thread.currentThread().getId();
			if (!mapEntityManager.containsKey(key)){
				EntityManager tmp = emf.createEntityManager();
				mapEntityManager.put(key, tmp);
			}
			return mapEntityManager.get(key);
		}
	}

	public void closeEntityManager(){
		synchronized(mapEntityManager){
			Long key =  Thread.currentThread().getId();
			EntityManager tmp = mapEntityManager.get(key);
			if (tmp != null) {
				if (tmp.isOpen()){
					tmp.close();
				}
			}
			mapEntityManager.remove(key);
			tmp = null;
		}			
	}

	public void startTran(){
		if (!getEmManager().getTransaction().isActive()){
			getEmManager().getTransaction().begin();
		}
	}

	public  void endTran(boolean commit) {
		try{
			startTran();
			if (getEmManager().getTransaction().isActive()){
				if (commit){
					getEmManager().getTransaction().commit();
				}else{
					getEmManager().getTransaction().rollback();
				}
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}

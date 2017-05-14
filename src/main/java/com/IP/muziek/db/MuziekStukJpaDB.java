package com.IP.muziek.db;

import com.IP.muziek.domain.MuziekStuk;

import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Sylvaren on 14/05/2017.
 */
public class MuziekStukJpaDB implements MuziekStukDB {

    EntityManager entityManager;
    EntityManagerFactory entityManagerFactory;

    public MuziekStukJpaDB(){
        entityManagerFactory = Persistence.createEntityManagerFactory("MuziekStukken");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @PreDestroy
    public void selfDestruct()
    {
        entityManagerFactory.close();
    }


    private void openConnection()
    {
        entityManager = entityManagerFactory.createEntityManager();
    }

    private void closeConnection()
    {
        entityManager.close();
    }

    private void roleBack()
    {
        entityManager.getTransaction().rollback();
    }

    @Override
    public MuziekStuk getMuziekStuk(String id) {
        MuziekStuk muziekStuk = null;

        try{
            openConnection();
            muziekStuk = entityManager.find(MuziekStuk.class, id);
        } catch (Exception e){
            roleBack();
            throw new DatabaseException(e.getMessage());
        }
        finally {
            closeConnection();
        }

        return muziekStuk;
    }

    @Override
    public void setMuziekStuk(MuziekStuk muziekStuk) {
        try{
            openConnection();
            entityManager.getTransaction().begin();
            entityManager.persist(muziekStuk);
            entityManager.getTransaction().commit();
        } catch (Exception e){
            roleBack();
            throw new DatabaseException(e.getMessage());
        }
        finally {
            closeConnection();
        }
    }

    @Override
    public MuziekStuk getLangsteStuk() {
        MuziekStuk output = null;
        try{
            openConnection();
            List<MuziekStuk> muziekstukken = entityManager.createQuery("Select c from MuziekStukken c", MuziekStuk.class).getResultList();

            for(MuziekStuk muziekStuk : muziekstukken) {
                if(output == null || muziekStuk.getDuur() > output.getDuur()){
                    output = muziekStuk;
                }

            }

        } catch (Exception e){
            roleBack();
            throw new DatabaseException(e.getMessage());
        }
        finally {
            closeConnection();
        }
        return output;
    }

    @Override
    public void verwijderMuziekStuk(MuziekStuk stuk) {

        try{
            openConnection();
            entityManager.getTransaction().begin();
           entityManager.createQuery("DELETE FROM MuziekStukken c WHERE c.id = " + stuk.getStukId() +" ", MuziekStuk.class).executeUpdate();
            entityManager.getTransaction().commit();
        } catch (Exception e){
            roleBack();
            throw new DatabaseException(e.getMessage());
        }
        finally {
            closeConnection();
        }

    }

    @Override
    public void updateMuziekStuk(MuziekStuk muziekStuk) {
        try
        {
            openConnection();

            entityManager.getTransaction().begin();
            MuziekStuk toUpdate = entityManager.find(MuziekStuk.class, muziekStuk.getStukId());

            entityManager.getTransaction().commit();

        }
        catch(Exception e)
        {
            roleBack();
            throw new DatabaseException(e.getMessage());
        }
        finally
        {
            closeConnection();
        }
    }

    @Override
    public HashMap<String, MuziekStuk> getAllStukken() {
        HashMap<String, MuziekStuk> answer = null;
        try{
            openConnection();
            List<MuziekStuk> muziekstukken = entityManager.createQuery("Select c from MuziekStukken c", MuziekStuk.class).getResultList();
            answer = new HashMap<>();
            for(MuziekStuk muziekStuk : muziekstukken) {
                answer.put(muziekStuk.getStukId(), muziekStuk);
            }

        } catch (Exception e){
            roleBack();
            throw new DatabaseException(e.getMessage());
        }
        finally {
            closeConnection();
        }

        return answer;
    }

    @Override
    public double gemiddeldeDuur() {

        double answer = 0;

        try{
            openConnection();
            List<MuziekStuk> muziekstukken = entityManager.createQuery("Select c from MuziekStukken c", MuziekStuk.class).getResultList();

            for(MuziekStuk muziekStuk : muziekstukken) {
                answer += muziekStuk.getDuur();
            }

            answer = answer/muziekstukken.size();

        } catch (Exception e){
            roleBack();
            throw new DatabaseException(e.getMessage());
        }
        finally {
            closeConnection();
        }

        return answer;
    }

    @Override
    public void verwijderMuziekStuk(String id) {

        try
        {
            openConnection();
            entityManager.getTransaction().begin();
            entityManager.createQuery("DELETE FROM MuziekStukken c WHERE c.id = " + id +" ", MuziekStuk.class).executeUpdate();
            entityManager.getTransaction().commit();
        }
        catch (Exception e)
        {
            roleBack();
            throw new DatabaseException(e.getMessage());
        }
        finally
        {
            closeConnection();
        }

    }
}

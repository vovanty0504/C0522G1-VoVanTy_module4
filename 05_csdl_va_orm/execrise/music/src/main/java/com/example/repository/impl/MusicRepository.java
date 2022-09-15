package com.example.repository.impl;

import com.example.model.Music;
import com.example.repository.IMusicRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

import static com.example.repository.impl.ConnectionUtil.entityManager;

@Repository
public class MusicRepository implements IMusicRepository {


    @Override
    public List<Music> findAll() {
        Session session = null;
        List<Music> musicList;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            musicList = session.createQuery("FROM Music").getResultList();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return musicList;
    }

    @Override
    public void save(Music music) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.save(music);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Music findById(int id) {
        Session session = null;
        Music music;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            music = (Music) session.createQuery
                    ("FROM Music where id = :id").setParameter("id", id).getSingleResult();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return music;
    }

    @Override
    public void update(Music music) {
        Transaction transaction = null;
        Session session = null;

        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.update(music);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void remove(int id) {
        Transaction transaction = null;
        Session session = null;
        Music music = findById(id);

        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.delete(music);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Music> findName(String name) {
        String queryStr = "SELECT m FROM Music AS m WHERE m.nameMusic LIKE :name";
        TypedQuery<Music> query = entityManager.createQuery(queryStr, Music.class);
        query.setParameter("name", "%" + name + "%");
        return query.getResultList();
    }
}

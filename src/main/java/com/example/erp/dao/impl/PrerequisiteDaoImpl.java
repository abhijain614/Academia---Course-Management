package com.example.erp.dao.impl;

import com.example.erp.bean.Prerequisite;
import com.example.erp.dao.PrerequisiteDao;
import com.example.erp.utils.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PrerequisiteDaoImpl implements PrerequisiteDao {
    @Override
   public boolean registerPrerequisite(Prerequisite prerequisite)
   {
       try (Session session = SessionUtil.getSession()) {
           Transaction transaction = session.beginTransaction();
           session.save(prerequisite);
           transaction.commit();
           return true;
       } catch (HibernateException exception) {
           System.out.print(exception.getLocalizedMessage());
           return false;
       }
   }

}

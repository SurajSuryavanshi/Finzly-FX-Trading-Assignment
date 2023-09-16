package com.finzly.FXTrading.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.finzly.FXTrading.entity.CurrencyExchange;

@Repository
public class CurrencyExchangeDao {

	@Autowired
	SessionFactory sessionFactory;
	

	public String addCurrencyExchange(CurrencyExchange currencyExchange) {
		System.out.println(currencyExchange);
		Session session=sessionFactory.openSession();
		session.save(currencyExchange);
		session.beginTransaction().commit();	
		return "Currency Pair added";
	}
	
	public Object checkcurrencyPair(String currencyPair)
	{
		Session session=sessionFactory.openSession();
		Criteria criteria=session.createCriteria(CurrencyExchange.class);
		criteria.add(Restrictions.eq("currencyPair",currencyPair ));
		if(criteria.list().size()!=0)
		{
			return criteria.list();
		}
		else {
			return null;
		}
	}
	public List<CurrencyExchange> getCurrencyPairRate(String currencyPair) {
		Session session=sessionFactory.openSession();
		Criteria criteria=session.createCriteria(CurrencyExchange.class);
		criteria.add(Restrictions.eq("currencyPair",currencyPair ));
		return criteria.list();
		
	}
}

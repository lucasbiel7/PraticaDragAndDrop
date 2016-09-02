/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.PraticaDragDrop.control.dao;

import br.com.PraticaDragDrop.model.GenericaDAO;
import br.com.PraticaDragDrop.model.entity.Cidade;
import java.util.List;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author OCTI01
 */
public class CidadeDAO extends GenericaDAO<Cidade> {

    public CidadeDAO() {
        super();
        criteria.addOrder(Order.asc("nome"));
    }

    public List<Cidade> pegarPorFavorito(boolean b) {
        entitys = criteria.add(Restrictions.eq("favorito", b)).list();
        closeSession();
        return entitys;
    }

}

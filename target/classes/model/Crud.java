/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Wanderson_M
 */
public abstract interface Crud<E> {

    public abstract int cadastrar(E entidade);

    public abstract void listar();

    public abstract int alterar(E entidade);

    public abstract int excluir(E entidade);

}

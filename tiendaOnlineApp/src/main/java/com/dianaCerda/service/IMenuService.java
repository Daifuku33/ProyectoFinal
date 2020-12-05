package com.dianaCerda.service;

import java.util.List;

import com.dianaCerda.model.Menu;

public interface IMenuService extends ICRUD<Menu> {

	List<Menu> listarMenuPorUsuario(String nombre);
}

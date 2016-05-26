package com.clandaith.gum.services;

import java.util.List;

import com.clandaith.gum.entities.Foobar;

public interface FoobarService {
	List<Foobar> listAllFoobars();

	Foobar getFoobarById(Integer id);

	Foobar saveFoobar(Foobar foobar);

}

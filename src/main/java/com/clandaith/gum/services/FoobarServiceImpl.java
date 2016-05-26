package com.clandaith.gum.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clandaith.gum.entities.Foobar;
import com.clandaith.gum.repositories.FoobarRepository;
import com.google.common.collect.Lists;

@Service
public class FoobarServiceImpl implements FoobarService {
	private FoobarRepository foobarRepository;

	@Autowired
	public void setFoobarRepository(FoobarRepository fbr) {
		this.foobarRepository = fbr;
	}

	@Override
	public List<Foobar> listAllFoobars() {
		return Lists.newArrayList(foobarRepository.findAll());
	}

	@Override
	public Foobar getFoobarById(Integer id) {
		return foobarRepository.findOne(id);
	}

	@Override
	@Transactional
	public Foobar saveFoobar(Foobar foobar) {
		return foobarRepository.save(foobar);
	}

}

package com.AtvAvaliativa.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AtvAvaliativa.entity.Aluno;
import com.AtvAvaliativa.entity.Turma;
import com.AtvAvaliativa.repository.TurmaRepository;

@Service
public class TurmaService  {
	
private final TurmaRepository turmaRepository;
	
	@Autowired
    public TurmaService(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }
	
	  public List<Turma> getAllTurma() {
	        return turmaRepository.findAll();
	    }

	    public Turma getTurmaById(Long id) {
	        Optional<Turma> turma = turmaRepository.findById(id);
	        return turma.orElse(null);
	    }
	  //Query Method
	    public List<Turma> buscarTurmasPorNome(String nome){
	    	return turmaRepository.findByNome(nome);
	    }
	  //Query Method
	    public List<Turma> buscarTurmasPorDescricao(String descricao){
	    	return turmaRepository.findByDescricao(descricao);
	    }
	  //Query Method
	    public List<Turma> buscarTurmasPorNomeAndDescricao(String nome, String descricao){
	    	return turmaRepository.findByNomeAndDescricao(nome,descricao);
	    }

	    public Turma salvarTurma(Turma turma) {
	        return turmaRepository.save(turma);
	    }

	    public Turma updateTurma(Long id, Turma updatedTurma) {
	        Optional<Turma> existingTurma = turmaRepository.findById(id);
	        if (existingTurma.isPresent()) {
	            updatedTurma.setId(id);
	            return turmaRepository.save(updatedTurma);
	        }
	        return null;
	    }

	    public boolean deleteTurma(Long id) {
	        Optional<Turma> existingTurma = turmaRepository.findById(id);
	        if (existingTurma.isPresent()) {
	        	turmaRepository.deleteById(id);
	            return true;
	        }
	        return false;
	    }
	  
}


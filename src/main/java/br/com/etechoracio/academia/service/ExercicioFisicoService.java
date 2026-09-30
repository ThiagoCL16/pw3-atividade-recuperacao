package br.com.etechoracio.academia.service;

import br.com.etechoracio.academia.dto.ExercicioFisicoRequestDTO;
import br.com.etechoracio.academia.dto.ExercicioFisicoResponseDTO;
import br.com.etechoracio.academia.entity.ExercicioFisico;
import br.com.etechoracio.academia.mapper.ExercicioFisicoMapper;
import br.com.etechoracio.academia.repository.ExercicioFisicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExercicioFisicoService {
    @Autowired
    private ExercicioFisicoRepository exercicioFisicoRepository;

    @Autowired
    private ExercicioFisicoMapper exercicioFisicoMapper;

    public List<ExercicioFisicoResponseDTO> findAprovados(){
        List<ExercicioFisico> exercicios = exercicioFisicoRepository.findAprovados();
        return exercicioFisicoMapper.toResponseDTOList(exercicios);
    }

    public ExercicioFisicoResponseDTO findPorId(Long id)
    {
        ExercicioFisico exercicio = exercicioFisicoRepository.findporId(id);
        if(exercicio == null)
            return null;
        else
            return exercicioFisicoMapper.toResponseDTO(exercicio);
    }

    public ExercicioFisicoResponseDTO save(ExercicioFisicoRequestDTO exercicioFisicoDto){
        ExercicioFisico exercicio = exercicioFisicoMapper.toEntity(exercicioFisicoDto);
        exercicio.setAprovado(false);
        ExercicioFisico exercicioSalvo = exercicioFisicoRepository.save(exercicio);
        return exercicioFisicoMapper.toResponseDTO(exercicioSalvo);
    }

}

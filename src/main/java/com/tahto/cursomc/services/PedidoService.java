package com.tahto.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tahto.cursomc.domain.Pedido;
import com.tahto.cursomc.repositories.PedidoRepository;
import com.tahto.cursomc.services.exceptions.ObjectNotFoundException;

/*
 * O papel do que chamamos de Controllers é de orquestração dos dados recebidos pela sua aplicação Java. 
 * Ele deve tratar as entradas do sistema com algumas verificações, como de tipos de dados, por exemplo, 
 * se um parâmetro obrigatório foi enviado na requisição. Depois dessas verificações, o Controller deve 
 * passar os dados recebidos pela requisição para o que chamamos de Services.

   Os Services são responsáveis pela lógica de negócio da sua aplicação, além de ser responsável por se comunicar com as 
   camadas mais internas do Software, como por exemplo, uma camada de Dados.
 */


@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repository;
	
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}

}

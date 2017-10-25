package view;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import controller.Util;
import annotation.MostrarAnot;
import annotation.ValorTypeAnot;
import domain.Cliente;
import domain.TesteValorTYpe;

public class Teste {

	public static void main(String[] args) throws InstantiationException,
			IllegalAccessException, InvocationTargetException {
		Cliente cliente = (Cliente) Util.createNewInstance(Cliente.class);

		cliente.setCodigo(1010);
		// cliente.setDataNascimento(new Date());
		cliente.setEnderecoCompleto("Rua ABC, Bairro YHU nº 190");
		cliente.setNome("Antonio da Silva Nunes");
		cliente.setNomeMae("Maria da Silva Nunes");
		cliente.setNomePai("Joao da Silva Nunes");
		Util.mostrarValores(cliente);
		TesteValorTYpe valorTeste = (TesteValorTYpe) Util.createNewInstance(TesteValorTYpe.class);
		Annotation a = valorTeste.getClass().getAnnotation(ValorTypeAnot.class);
		ValorTypeAnot vlrTypeAnot = (ValorTypeAnot) a;
		System.out.println(vlrTypeAnot.nome());
		

		// if(cliente == null){
		// System.err.println("Não foi possível criar o objeto cliente");
		// }else{
		// System.out.println("Objeto Cliente criado = "+ cliente.toString());
		// }

		// busaca de todos os campos da classe Cliente
		// for(Field f : clazz.getDeclaredFields()){
		// System.out.println(f.getName());
		// }
		// Busca todos os metodos da classe
		// for(Method m : clazz.getDeclaredMethods()){
		// System.out.println(m.getName());
		// }

	}

	
}

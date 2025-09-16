import application.lanchonete.CadastrarLanche;
import application.lanchonete.CriarPedidos;
import application.lanchonete.FinalizarPedidos;
import application.lanchonete.ListarLanches;
import application.quarto.CadastrarQuarto;
import application.quarto.ListarQuartos;
import application.quarto.ReservarQuartos;
import application.tarefa.ConcluirTarefa;
import application.tarefa.CriarTarefa;
import application.tarefa.ListarTarefasPendentes;
import entities.filme.Filme;
import entities.lanchonete.Lanche;
import entities.lanchonete.Pedido;
import entities.quarto.Quarto;
import exceptions.FilmeNaoEncontradoException;
import infrastucture.*;

import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Exercicio 1 - cadastro de alunos
        System.out.println("Exercicio 1 - cadastro de alunos");
        AlunoRepository alunoRepo = new AlunoRepository();
        alunoRepo.salvar(new entities.aluno.Aluno("João", "2023001", "Engenharia"));
        alunoRepo.salvar(new entities.aluno.Aluno("Maria", "2023002", "Medicina"));

        alunoRepo.listarTodos().forEach(aluno ->
            System.out.println("Nome: " + aluno.getNome() + ", Matrícula: " + aluno.getMatricula() + ", Curso: " + aluno.getCurso())
        );

        //Exercicio 2 - cadastro de funcionarios
        System.out.println("Exercicio 2 - Listagem de funcionários");
        FuncionarioRepository funcionarioRepo = new FuncionarioRepository();
        funcionarioRepo.salvar(new entities.funcionario.Funcionario("Carlos", "Gerente", 8000));
        funcionarioRepo.salvar(new entities.funcionario.Funcionario("Ana", "Assistente", 4000));

        funcionarioRepo.listarTodos().forEach(funcionario ->
            System.out.println("Nome: " + funcionario.getNome() + ", Cargo: " + funcionario.getCargo() + ", Salário: " + funcionario.getSalario())
        );

        //Exercicio 3 - Buscar filme por titulo
        System.out.println("Buscar filme por título");
        FilmeRepository filmeRepo = new FilmeRepository();
        filmeRepo.salvar(new entities.filme.Filme("Inception", "Christopher Nolan", 2010));
        filmeRepo.salvar(new entities.filme.Filme("Matrix", "The Wachowskis", 1999));

        try {
            Filme filme = filmeRepo.buscarPorTitulo("Matrix");
            System.out.println("Filme encontrado: " + filme.getTitulo() + " (" + filme.getAno() + ")");
        } catch (FilmeNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }

        try {
            Filme filme = filmeRepo.buscarPorTitulo("Avatar");
            System.out.println("Filme encontrado: " + filme.getTitulo());
        } catch (FilmeNaoEncontradoException e) {
            System.out.println("Erro: " + e.getMessage());
        }


        //Parte 2
        //Exercicio 4 - Cadastrar e reservar quartos
        QuartoRepository quartoRepo = new QuartoRepositoryImpl();

        CadastrarQuarto cadastrarQuarto = new CadastrarQuarto(quartoRepo);
        ListarQuartos listarQuartos = new ListarQuartos(quartoRepo);
        ReservarQuartos reservarQuartos = new ReservarQuartos(quartoRepo);

        cadastrarQuarto.executar(new Quarto(101, "Solteiro"));
        cadastrarQuarto.executar(new Quarto(102, "Casal"));

        listarQuartos.executar().forEach(System.out::println);

        reservarQuartos.executar(101);

        System.out.println("\nApós reserva:");
        listarQuartos.executar().forEach(System.out::println);

        //Exercicio 5 - Gerenciamento de tarefas
        TarefaRepository tarefaRepo = new TarefaRepositoryImpl();
        CriarTarefa criarTarefa = new CriarTarefa(tarefaRepo);
        ListarTarefasPendentes listarTarefasPendentes = new ListarTarefasPendentes(tarefaRepo);
        ConcluirTarefa concluirTarefa = new ConcluirTarefa(tarefaRepo);

        criarTarefa.executar("Estudar Clean Architecture");
        criarTarefa.executar("Fazer exercícios de Java");
        criarTarefa.executar("Enviar atividade para o professor");

        System.out.println("\nTarefas pendentes:");
        listarTarefasPendentes.executar().forEach(System.out::println);

        concluirTarefa.executar("Fazer exercícios de Java");

        System.out.println("\nApós concluir:");
        listarTarefasPendentes.executar().forEach(System.out::println);

        //Exercicio 6 - Sistema de lanchonete
        LancheRepository lancheRepo = new LancheRepository();
        PedidoRepository pedidoRepo = new PedidoRepository();

        CadastrarLanche cadastrarLanche = new CadastrarLanche(lancheRepo);
        ListarLanches listarLanches = new ListarLanches(lancheRepo);
        CriarPedidos criarPedidos = new CriarPedidos(pedidoRepo);
        FinalizarPedidos finalizarPedidos = new FinalizarPedidos();

        cadastrarLanche.executar("X-Burger", 15.0, true);
        cadastrarLanche.executar("X-Salada", 18.0, true);
        cadastrarLanche.executar("Refrigerante", 5.0, true);

        System.out.println("=== Cardápio ===");
        List<Lanche> cardapio = listarLanches.executar();
        cardapio.forEach(l ->
                System.out.println(l.getNome() + " - R$" + l.getPreco() + " - Disponível: " + l.isDisponivel())
        );

        try {
            Pedido pedido = criarPedidos.executar(Arrays.asList(
                    cardapio.get(0),
                    cardapio.get(1),
                    cardapio.get(2)
            ));
            System.out.println("\nPedido criado. Total: R$" + pedido.getValorTotal());
        } catch (Exception e) {
            System.out.println("Erro ao criar pedido: " + e.getMessage());
        }

        Pedido pedidoValido = criarPedidos.executar(Arrays.asList(
                cardapio.get(0),
                cardapio.get(1)
        ));
        System.out.println("\nPedido criado com sucesso! Valor total: R$" + pedidoValido.getValorTotal());

        finalizarPedidos.executar(pedidoValido);
        System.out.println("Pedido finalizado: " + pedidoValido.isFinalizado());

        try {
            pedidoValido.adicionarLanche(cardapio.get(2));
        } catch (Exception e) {
            System.out.println("Erro ao adicionar lanche após finalização: " + e.getMessage());
        }
    }
}
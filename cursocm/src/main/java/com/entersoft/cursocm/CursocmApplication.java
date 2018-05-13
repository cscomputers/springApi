package com.entersoft.cursocm;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.entersoft.cursocm.domain.Categoria;
import com.entersoft.cursocm.domain.Cidade;
import com.entersoft.cursocm.domain.Cliente;
import com.entersoft.cursocm.domain.Endereco;
import com.entersoft.cursocm.domain.Estado;
import com.entersoft.cursocm.domain.ItemPedido;
import com.entersoft.cursocm.domain.Pagamento;
import com.entersoft.cursocm.domain.PagamentoComBoleto;
import com.entersoft.cursocm.domain.PagamentoComCartao;
import com.entersoft.cursocm.domain.Pedido;
import com.entersoft.cursocm.domain.Produto;
import com.entersoft.cursocm.domain.enums.EstadoPagamento;
import com.entersoft.cursocm.domain.enums.TipoCliente;
import com.entersoft.cursocm.repositories.CategoriaRepository;
import com.entersoft.cursocm.repositories.CidadeRepository;
import com.entersoft.cursocm.repositories.ClienteRepository;
import com.entersoft.cursocm.repositories.EnderecoRepository;
import com.entersoft.cursocm.repositories.EstadoRepository;
import com.entersoft.cursocm.repositories.ItemPedidoRepository;
import com.entersoft.cursocm.repositories.PagamentoRepository;
import com.entersoft.cursocm.repositories.PedidoRepository;
import com.entersoft.cursocm.repositories.ProdutoRepository;

@SpringBootApplication
public class CursocmApplication implements CommandLineRunner{

	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	EstadoRepository estadoRepository;
	
	@Autowired
	CidadeRepository cidadeRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	@Autowired
	PagamentoRepository pagamentoRepository;
	
	@Autowired
	ItemPedidoRepository itemPedidoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursocmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritório");
		Categoria cat3 = new Categoria(null, "Casa e Jardim");
		Categoria cat4 = new Categoria(null, "Cama, mesa e banho");
		Categoria cat5 = new Categoria(null, "TV´s");
		Categoria cat6 = new Categoria(null, "Eletônicos");
		Categoria cat7 = new Categoria(null, "Celulares");
		Categoria cat8 = new Categoria(null, "Tablets");
		Categoria cat9 = new Categoria(null, "Praia");
		Categoria cat10 = new Categoria(null, "Esportes");
		Categoria cat11 = new Categoria(null, "Automóveis");
		Categoria cat12 = new Categoria(null, "Bicicletas");
		Categoria cat13 = new Categoria(null, "Material escolar");
		Categoria cat14 = new Categoria(null, "Materia de limpeza");
		Categoria cat15 = new Categoria(null, "Utencílios domésticos");
		Categoria cat16 = new Categoria(null, "Linha branca");
		Categoria cat17 = new Categoria(null, "Condicionadores de ar");
		Categoria cat18 = new Categoria(null, "Roupas e acessórios");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, 
				cat6, cat7, cat8, cat9, cat10, cat11, cat12, cat13, cat14, cat15, cat16, cat17, cat18));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "2877885433", TipoCliente.PESSOA_FISICA);
		cli1.getTelefones().addAll(Arrays.asList("4132575700", "41995454400"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "32208834", cli1, c1);
		Endereco e2 = new Endereco(null, "Av Matos", "105", "Sala 800", "Centro", "32208300", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, p1.getPreco());
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, p3.getPreco());
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, p2.getPreco());
		
		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
		
	}
}

package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class TestCupomFiscal {

	private String BREAK = System.lineSeparator();
	
	private String TEXTO_ESPERADO_LOJA_COMPLETA = "Loja 1" + BREAK +
			"Log 1, 10 C1" + BREAK +
			"Bai 1 - Mun 1 - E1" + BREAK +
			"CEP:11111-111 Tel (11) 1111-1111" + BREAK +
			"Obs 1" + BREAK +
			"CNPJ: 11.111.111/1111-11" + BREAK +
			"IE: 123456789" + BREAK;

	private String TEXTO_ESPERADO_SEM_NUMERO = "Loja 1" + BREAK +
			"Log 1, s/n C1" + BREAK +
			"Bai 1 - Mun 1 - E1" + BREAK +
			"CEP:11111-111 Tel (11) 1111-1111" + BREAK +
			"Obs 1" + BREAK +
			"CNPJ: 11.111.111/1111-11" + BREAK +
			"IE: 123456789" + BREAK;

	private String TEXTO_ESPERADO_SEM_COMPLEMENTO = "Loja 1" + BREAK +
			"Log 1, 10" + BREAK +
			"Bai 1 - Mun 1 - E1" + BREAK +
			"CEP:11111-111 Tel (11) 1111-1111" + BREAK +
			"Obs 1" + BREAK +
			"CNPJ: 11.111.111/1111-11" + BREAK +
			"IE: 123456789" + BREAK;

	private String TEXTO_ESPERADO_SEM_BAIRRO = "Loja 1" + BREAK +
			"Log 1, 10 C1" + BREAK +
			"Mun 1 - E1" + BREAK +
			"CEP:11111-111 Tel (11) 1111-1111" + BREAK +
			"Obs 1" + BREAK +
			"CNPJ: 11.111.111/1111-11" + BREAK +
			"IE: 123456789" + BREAK;

	private String TEXTO_ESPERADO_SEM_CEP = "Loja 1" + BREAK +
			"Log 1, 10 C1" + BREAK +
			"Bai 1 - Mun 1 - E1" + BREAK +
			"Tel (11) 1111-1111" + BREAK +
			"Obs 1" + BREAK +
			"CNPJ: 11.111.111/1111-11" + BREAK +
			"IE: 123456789" + BREAK;

	private String TEXTO_ESPERADO_SEM_TELEFONE = "Loja 1" + BREAK +
			"Log 1, 10 C1" + BREAK +
			"Bai 1 - Mun 1 - E1" + BREAK +
			"CEP:11111-111" + BREAK +
			"Obs 1" + BREAK +
			"CNPJ: 11.111.111/1111-11" + BREAK +
			"IE: 123456789" + BREAK;

	private String TEXTO_ESPERADO_SEM_OBSERVACAO = "Loja 1" + BREAK +
			"Log 1, 10 C1" + BREAK +
			"Bai 1 - Mun 1 - E1" + BREAK +
			"CEP:11111-111 Tel (11) 1111-1111" + BREAK +
			"" + BREAK +
			"CNPJ: 11.111.111/1111-11" + BREAK +
			"IE: 123456789" + BREAK;

	@BeforeAll
	public static void setup() {
		CupomFiscal.NOME_LOJA = "Loja 1";
		CupomFiscal.LOGRADOURO = "Log 1";
		CupomFiscal.NUMERO = 10;
		CupomFiscal.COMPLEMENTO = "C1";
		CupomFiscal.BAIRRO = "Bai 1";
		CupomFiscal.MUNICIPIO = "Mun 1";
		CupomFiscal.ESTADO = "E1";
		CupomFiscal.CEP = "11111-111";
		CupomFiscal.TELEFONE = "(11) 1111-1111";
		CupomFiscal.OBSERVACAO = "Obs 1";
		CupomFiscal.CNPJ = "11.111.111/1111-11";
		CupomFiscal.INSCRICAO_ESTADUAL = "123456789";
	}

	@Test
	public void lojaCompleta() {
		rodarTestarRetorno(TEXTO_ESPERADO_LOJA_COMPLETA);
	}

	@Test
	public void nomeVazio() {
		CupomFiscal.NOME_LOJA = "";
		verificarCampoObrigatorio("O campo nome da loja é obrigatório");
		CupomFiscal.NOME_LOJA = "Loja 1";
	}

	@Test
	public void logradouroVazio() {
		CupomFiscal.LOGRADOURO = "";
		verificarCampoObrigatorio("O campo logradouro do endereço é obrigatório");
		CupomFiscal.LOGRADOURO = "Log 1";
	}

	@Test
	public void numeroZero() {
		CupomFiscal.NUMERO = 0;
		rodarTestarRetorno(TEXTO_ESPERADO_SEM_NUMERO);
		CupomFiscal.NUMERO = 10;
	}

	@Test
	public void complementoVazio() {
		CupomFiscal.COMPLEMENTO = "";
		rodarTestarRetorno(TEXTO_ESPERADO_SEM_COMPLEMENTO);
		CupomFiscal.COMPLEMENTO = "C1";
	}

	@Test
	public void bairroVazio() {
		CupomFiscal.BAIRRO = "";
		rodarTestarRetorno(TEXTO_ESPERADO_SEM_BAIRRO);
		CupomFiscal.BAIRRO = "Bai 1";
	}

	@Test
	public void municipioVazio() {
		CupomFiscal.MUNICIPIO = "";
		verificarCampoObrigatorio("O campo município do endereço é obrigatório");
		CupomFiscal.MUNICIPIO = "Mun 1";
	}

	@Test
	public void estadoVazio() {
		CupomFiscal.ESTADO = "";
		verificarCampoObrigatorio("O campo estado do endereço é obrigatório");
	    CupomFiscal.ESTADO = "E1";
	}

	@Test
	public void cepVazio() {
		CupomFiscal.CEP = "";
		rodarTestarRetorno(TEXTO_ESPERADO_SEM_CEP);
	    CupomFiscal.CEP = "11111-111";
	}

	@Test
	public void telefoneVazio() {
		CupomFiscal.TELEFONE = "";
		rodarTestarRetorno(TEXTO_ESPERADO_SEM_TELEFONE);
	    CupomFiscal.TELEFONE = "(11) 1111-1111";
	}

	@Test
	public void observacaoVazia() {
		CupomFiscal.OBSERVACAO = "";
		rodarTestarRetorno(TEXTO_ESPERADO_SEM_OBSERVACAO);
	    CupomFiscal.OBSERVACAO = "Obs 1";
	}

	@Test
	public void cnpjVazio() {
		CupomFiscal.CNPJ = "";
		verificarCampoObrigatorio("O campo CNPJ da loja é obrigatório");
	    CupomFiscal.CNPJ = "11.111.111/1111-11";
	}

	@Test
	public void inscricaoEstadualVazia() {
		CupomFiscal.INSCRICAO_ESTADUAL = "";
		verificarCampoObrigatorio("O campo inscrição estadual da loja é obrigatório");
		CupomFiscal.INSCRICAO_ESTADUAL = "123456789";
	}
	
	@Test
	public void exercicio02_Customizado() {
		//Defina seus próprios valores para as variáveis a seguir 
		CupomFiscal.NOME_LOJA = "Andrea Docas";
		CupomFiscal.LOGRADOURO = "Rua Setorial";
		CupomFiscal.NUMERO = 0;
		CupomFiscal.COMPLEMENTO = "Próximo ao forte";
		CupomFiscal.BAIRRO = "Camboriu";
		CupomFiscal.MUNICIPIO = "Cabedelo";
		CupomFiscal.ESTADO = "PB";
		CupomFiscal.CEP = "58038-000";
		CupomFiscal.TELEFONE = "(83) 8888-7777";
		CupomFiscal.OBSERVACAO = "Entrada Km 7";
		CupomFiscal.CNPJ = "42.591.651/0797-34";
		CupomFiscal.INSCRICAO_ESTADUAL = "244.898.500.113";
		
		//E atualize o texto esperado abaixo
		rodarTestarRetorno(
			"Andrea Docas" + BREAK +
			"Rua Setorial, s/n Próximo ao forte" + BREAK +
			"Camboriu - Cabedelo - PB" + BREAK +
			"CEP:58038-000 Tel (83) 8888-7777" + BREAK +
			"Entrada Km 7" + BREAK +
			"CNPJ: 42.591.651/0797-34" + BREAK +
			"IE: 244.898.500.113" + BREAK
		);
	}

	private void rodarTestarRetorno(String expected) {

		// action
		String retorno = CupomFiscal.dadosLoja();

		// assertion
		assertEquals(expected, retorno);
	}
	
	private void verificarCampoObrigatorio(String mensagemEsperada) {
		try {
			CupomFiscal.dadosLoja();
		} catch (RuntimeException e) {
			assertEquals(mensagemEsperada, e.getMessage());
		}
	}
	
}

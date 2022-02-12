package model;

public class App {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DAO maca = new DAO();
		System.out.println(maca.exibirVeiculos());
		
		Veiculos laranja = new Veiculos("Golf Sapão", "Volksvagem",2015);
		maca.adicionarVeiculo(laranja);
		System.out.println(maca.exibirVeiculos());
		
//		User laranja1 = new User("Will", "Japão", "melao@rd.com.br");
//		maca.insert(laranja1);
//		System.out.println(maca.selectAll());
//		
//		maca.delete(2);
//		System.out.println(maca.selectAll());
//		
//		User laranja2 = new User("Muryllo", "Malásia", "uva@rd.com.br");
//		maca.insert(laranja2);
//		System.out.println(maca.selectAll());
//		
//		maca.delete(2);
//		System.out.println(maca.selectAll());
//		
//		laranja.setPais("Holanda");
//		maca.update(laranja);
//		System.out.println(maca.selectAll());
//		
//		User novo = maca.selectById(3);
//		System.out.println(novo);
//		
//		User novo1 = maca.selectById(10);
//		System.out.println(novo1);
	}

}




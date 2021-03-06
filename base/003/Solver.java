import java.util.Scanner;

class Pessoa {
    String nome;
    int idade;

    public Pessoa(String nome, int idade){ //nao eh metodo, eh invocado automaticaticamente na criacao
        this.nome = nome;
        this.idade = idade;
    }

    public String toString(){
        return "[" + this.nome + ":" + this.idade + "]";
    }
}

class Motoca {
	Pessoa pessoa; //agregacao
    int potencia;
    int tempo;

	public Motoca(int potencia){
        this.potencia = potencia;
        this.tempo = 0;
	}
	~Motoca(){
		if(pessoa)
			delete pessoa;
	}
    
    void comprar(int tempo){
        this.tempo += tempo;
    }
	
	boolean embarcar(Pessoa pessoa) {
		if(this.pessoa == null){
			this.pessoa = pessoa;
			return true;
		}
		System.out.println("fail: moto ocupada");
		return false;
	}
	
	Pessoa desembarcar() {
		if(this.pessoa != null){
			Pessoa pessoa = this.pessoa;
			this->pessoa = null;
			return pessoa;
		}else{
			System.out.println("fail: moto vazia");
			return null;
		}
	}

	void dirigir(int tempo){
		if(this.pessoa == null)
			System.out.println("fail: moto vazia");
		else if(this.pessoa.idade > 10)
			System.out.println("fail: muito grande para andar de moto");
        else if(this.tempo == 0)
			System.out.println("fail: tempo zerado");
        else if(this.tempo < tempo){
            System.out.println("fail: andou " + this.tempo + " min e acabou o tempo");
            this.tempo = 0;
        }else
            this.tempo -= tempo;
    }

	void buzinar(){
        if(this.pessoa == null){
            System.out.println("fail: moto vazia");
            return;
        }
		String saida = "";
		for(int i = 0; i < this.potencia; i++)
			saida += "e";
		System.out.println("P" + saida + "m");
    }
    
    public String toString(){
        return "potencia: " + this.potencia + ", minutos: " + this.tempo + ", pessoa: " + this.pessoa;
    }
}

public class Solver{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Motoca motoca  = new Motoca(1);
		while(true) {
			String line = scanner.nextLine();
            String ui[] = line.split(" "); //ui user input eh um vetor de strings
            System.out.println("$" + line);
			if(ui[0].equals("end")) {
				break;
			}else if(ui[0].equals("init")) { //potencia
				Pessoa pessoa = motoca.pessoa;
				motoca = new Motoca(Integer.parseInt(ui[1]));
				motoca.embarcar(pessoa);
			}else if(ui[0].equals("in")) { //in nome idade
				int idade = Integer.parseInt(ui[2]);
				Pessoa * pessoa = new Pessoa(ui[1], idade);
				if(!motoca.embarcar(pessoa))
					delete pessoa;
			}else if(ui[0].equals("out")) {
				Pessoa * pessoa = motoca.desembarcar();
				if(pessoa)
					delete pessoa;
			}else if(ui[0].equals("show")) {
				System.out.println(motoca);
			}else if(ui[0].equals("drive")) {
				motoca.dirigir(Integer.parseInt(ui[1]));
			}else if(ui[0].equals("buy")) {
				motoca.comprar(Integer.parseInt(ui[1]));
			}else if(ui[0].equals("buzinar")) {
				motoca.buzinar();
			}else {
				System.out.println("Comando invalido");
			}
		}
		delete motoca;
		scanner.close();
	}
}







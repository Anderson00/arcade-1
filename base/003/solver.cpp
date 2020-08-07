#include <iostream>
#include <string>
#include <sstream>

using namespace std;

class Pessoa {

public:

    Pessoa(string nome, int idade){ //nao eh metodo, eh invocado automaticaticamente na criacao
        this->nome = nome;
        this->idade = idade;
    }
    
    string toString(){
        return "[" + this.nome + ":" + this.idade + "]";
    }

private:
    string nome;
    int idade;
};

class Motoca {

public:

	Motoca(int potencia){
        this->potencia = potencia;
        this->tempo = 0;
	}
	~Motoca(){
        
	}
    
    void comprar(int tempo){
        this->tempo += tempo;
    }
	
	bool embarcar(Pessoa pessoa) {
		if(temPassageiro == false){
			this->pessoa = pessoa;
            temPassageiro = true;
			return true;
		}
		cout << "fail: moto ocupada" << endl;
		return false;
	}
	
	Pessoa* desembarcar() {
		if(temPassageiro){
			return &pessoa;
		}else{
			cout << "fail: moto vazia" << endl;
			return nullptr;
		}
	}

	void dirigir(int tempo){
		if(temPassageiro == false)
			cout << "fail: moto vazia" << endl;
		else if(this->pessoa.idade > 10)
			cout << "fail: muito grande para andar de moto" << endl;
        else if(this->tempo == 0)
			cout << "fail: tempo zerado" << endl;
        else if(this->tempo < tempo){
            cout << "fail: andou " + this->tempo + " min e acabou o tempo" << endl;
            this->tempo = 0;
        }else
            this->tempo -= tempo;
    }

	void buzinar(){
        if(temPassageiro){
            cout << "fail: moto vazia" << endl;
            return;
        }
		string saida = "";
		for(int i = 0; i < this->potencia; i++)
			saida += "e";
		cout << "P" + saida + "m" << endl;
    }
    
    string toString(){
        stringstream str;
        str << "potencia: " << this->potencia << ", minutos: " << this.tempo << ", pessoa: " << this.pessoa;
        return str.str();
    }


private:
    Pessoa pessoa; //agregacao
    bool temPassageiro = false;
    int potencia;
    int tempo;
}

int main(){


    return 0;
}
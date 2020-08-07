#include <iostream>
#include <vector>
#include <sstream>

using namespace std;

//Prototypes
void vet_show(vector<int>& vet);
void vet_rshow(vector<int>& vet);
void vet_rshow2(vector<int>& vet);
int vet_find(vector<int>& vet, int value);

//mostra o vetor
void vet_show(vector<int>& vet){
    cout << "[ ";
    for(int value : vet)
        cout << value << " ";
    cout << "]\n";
}

// mostra o vetor ao contrário
void vet_rshow(vector<int>& vet){
    cout << "[ ";
    for(std::vector<int>::reverse_iterator it = vet.rbegin(); it != vet.rend(); it++)
        cout << *it << " ";
    cout << "]\n";
}

//mostra o vetor ao contrário 2. não usa iterators
void vet_rshow2(vector<int>& vet){
    cout << "[ ";

    for(int i = vet.size() - 1; i >= 0; i--){
        cout << vet[i] << " ";
    }

    cout << " ]" << endl;
}

//retorna o índice que contém value ou -1 se não existir
int vet_find(vector<int>& vet, int value){
    for(size_t i = 0; i < vet.size(); i++)
        if(vet[i] == value)
            return i;
    return -1;
}

int main(){
    vector<int> vet;
    string line;

    while(true){
        getline(cin, line);
        stringstream ss(line);
        cout << "$" << line << "\n";
        string cmd;
        ss >> cmd; //pegando o primeiro token

        if(line == "end"){
            break;
        }else if(cmd == "add"){
            int value;
            while(ss >> value) //enquanto conseguir retirar valores
                vet.push_back(value);
        }else if(cmd == "show"){
            vet_show(vet);
        }else if(cmd == "rshow"){
            vet_rshow(vet);
        }else if(cmd == "get"){
            int ind;
            ss >> ind;
            cout << vet[ind] << "\n";
        }else if(cmd == "set"){
            int ind, value;
            ss >> ind >> value;
            vet[ind] = value;
        }else if(cmd == "find"){
            int value;
            cout << "[ ";
            while(ss >> value) //enquanto conseguir retirar tokens
                cout << vet_find(vet, value) << " "; //converte pra inteiro e imprime
            cout << "]\n";
        }else if(cmd == "rmi"){
            int ind;
            ss >> ind;
            if(ind >=0 && ind < (int) vet.size())
                vet.erase(vet.begin() + ind);
            else
                cout << "fail\n";
        }else if(cmd == "ins"){
            int ind; 
            int value;
            ss >> ind >> value;
            if(ind < 0)
                continue;
            if(ind >= (int)vet.size())
                ind = vet.size();
            vet.insert(vet.begin() + ind, value);
        }else if(cmd == "rma"){
            int value;
            ss >> value;
            for(vector<int>::iterator it = vet.begin(); it != vet.end();){
                if(*it == value){
                    it = vet.erase(it);
                }else{
                    it++;
                }
            }
        }else{
            cout << "Comando invalido\n";
        }
    }
    return 0;
}

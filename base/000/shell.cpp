#include <iostream>
#include <sstream>

using namespace std;

int main(){
    string line;
    string cmd;

    while(true){
        cmd.clear(); // retira o comando anterior
        getline(cin, line);
        stringstream ss(line);
        ss >> cmd;
        
        if(line == "end"){
            break;
        }else{
            cout << "fail: command not found" << endl;
        }
    }

    return 0;
}
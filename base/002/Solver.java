import java.util.ArrayList;
import java.util.Scanner;

public class Solver{	
	static Scanner scan = new Scanner(System.in);

    static class Carro{

        private int pass, passMax, gas, gasMax, km;

        Carro(int pass, int passMax, int gas, int gasMax, int km){
            this.pass = pass;       // Passageiros
            this.passMax = passMax; // limite de Passageiros
            this.gas = gas;         // tanque
            this.gasMax = gasMax;   // limite do tanque
            this.km = km;           // quantidade de quilometragem
        }

        @Override
        public String toString(){
            return "pass: " + pass + ", gas: " + gas + ", km: " + km;
        }

        public void in(){
            if (this.pass < this.passMax){
                this.pass += 1;
                return;
            }
            System.out.println("fail: limite de pessoas atingido");
        }

        public void out(){
            if (this.pass > 0){
                this.pass -= 1;
                return;
            }
            System.out.println("fail: nao ha ninguem no carro");
        }

        void fuel(int gas){
            this.gas += gas;
            if(this.gas > gasMax)
                this.gas = gasMax;
        }

        void drive (int km){
            if(this.pass == 0){
                System.out.println("fail: nao ha ninguem no carro");
            }else if(this.gas == 0){
                System.out.println("fail: tanque vazio");
            }
            else if(this.gas < km){
                System.out.println("fail: tanque vazio apos andar " + this.gas +" km");
                this.km += this.gas;
                this.gas = 0;
            }else{
                this.gas -= km;
                this.km += km;
            }
        }  
    }

    public static void main(String[] args){
        Solver.Carro carro = new Solver.Carro(0, 0, 0, 0, 0);

        Scanner scan = new Scanner(System.in);

        while(true){
            String line = scan.nextLine();
            System.out.println("$" + line);

            if(line.equals("end")){
                break;
            }

            String ui[] = line.split(" ");
            if(ui[0].equals("init")){
                int pass, passMax, gas, gasMax, km;
                pass = Integer.parseInt(ui[1]);
                passMax = Integer.parseInt(ui[2]);
                gas = Integer.parseInt(ui[3]);
                gasMax = Integer.parseInt(ui[4]);
                km = Integer.parseInt(ui[5]);
                
                carro = new Solver.Carro(pass, passMax, gas, gasMax, km);
            }else if(ui[0].equals("help")){
                System.out.println("in; out; show; fuel _gas; drive _km");
            }else if(ui[0].equals("in")){
                carro.in();
            }else if(ui[0].equals("out")){
                carro.out();
            }else if(ui[0].equals("show")){
                System.out.println(carro);
            }else if(ui[0].equals("drive")){
                carro.drive(Integer.parseInt(ui[1]));
            }else if(ui[0].equals("fuel")){
                carro.fuel(Integer.parseInt(ui[1]));
            }else{
                System.out.println("fail: comando invalido");
            }
        }
    }
}
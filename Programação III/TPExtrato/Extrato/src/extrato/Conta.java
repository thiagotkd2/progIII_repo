/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package extrato;

import java.util.Objects;

/**
 *
 * @author Thiago
 */
public class Conta {

    private int numero_conta;
    private ListaEncadeada<Extrato> extrato;
    
    public Conta(){
        extrato = new ListaEncadeada();
    }

    public void setNumero_conta(int numero_conta) {
        this.numero_conta = numero_conta;
    }

    public void setValores(ListaEncadeada valores) {
        this.extrato = valores;
    }

    public int getNumero_conta() {
        return numero_conta;
    }

    public ListaEncadeada<Extrato> getExtrato() {
        return extrato;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Conta other = (Conta) obj;
        return this.numero_conta == other.numero_conta;
    } 
}
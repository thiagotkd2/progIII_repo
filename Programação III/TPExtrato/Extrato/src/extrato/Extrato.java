/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package extrato;

/**
 *
 * @author Thiago
 */
public class Extrato {
    private int operacao;
    private double valor;

    public int getOperacao() {
        return operacao;
    }

    public void setOperacao(int operacao) {
        this.operacao = operacao;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
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
        final Extrato other = (Extrato) obj;
        if (this.operacao != other.operacao) {
            return false;
        }
        return Double.doubleToLongBits(this.valor) == Double.doubleToLongBits(other.valor);
    }   
}
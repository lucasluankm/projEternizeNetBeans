/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

/**
 *
 * @author 277882
 */
public class Empresa {
    
    private int cnpj_empresa;
    private String nome_empresa;
    private String local_empresa;
    private String tel_empresa;

    public int getCnpj_empresa() {
        return cnpj_empresa;
    }

    public void setCnpj_empresa(int cnpj_empresa) {
        this.cnpj_empresa = cnpj_empresa;
    }

    public String getNome_empresa() {
        return nome_empresa;
    }

    public void setNome_empresa(String nome_empresa) {
        this.nome_empresa = nome_empresa;
    }

    public String getLocal_empresa() {
        return local_empresa;
    }

    public void setLocal_empresa(String local_empresa) {
        this.local_empresa = local_empresa;
    }

    public String getTel_empresa() {
        return tel_empresa;
    }

    public void setTel_empresa(String tel_empresa) {
        this.tel_empresa = tel_empresa;
    }
    
}

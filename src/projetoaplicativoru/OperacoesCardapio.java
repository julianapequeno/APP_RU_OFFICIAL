/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoaplicativoru;

import projetoaplicativoru.Cardapio;

/**
 *
 * @author julia_000
 */
public interface OperacoesCardapio {
    public void incluirCardapio(Cardapio c);
    public void excluirCardapio(int cp);
    public void alteraCardapio(Cardapio c, int cp);
}

(ns desafio-semana-1.logic.db)
;Client
;Nome,CPF,Email
(def cliente {:nome "Clodovaldo"
              :cpf "12312312312"
              :email "clodovaldo@nu.com.br"})
;Cartao
;numero;cvv;validade;limite
(def cartao {:numero "1111444455556666"
             :cvv "111"
             :validade "12/21"
             :limite 50.00})
;Compras
;data;valor;estabelecimento;categoria
(def compra1 {:data "25/01/2022"
              :categoria "Saúde"
              :valor 27
              :estabelecimento "Drogasil"})
(def compra2 {:data "29/01/2021"
              :categoria "Saúde"
              :valor 437
              :estabelecimento "Pharmapele"})
(def compra3 {:data "08/01/2021"
              :categoria "Educação"
              :valor 29
              :estabelecimento "Udemy"})
(def compra4 {:data "25/01/2021"
              :categoria "Alimentação"
              :valor 54
              :estabelecimento "Jolu Sushi"})
(def compra5 {:data "09/01/2021"
              :categoria "Alimentação"
              :valor 564
              :estabelecimento "Parraxaxá"})
(def compra6 {:data "15/02/2021"
              :categoria "Educação"
              :valor 254
              :estabelecimento "Cambly"})
(def compra7 {:data "14/02/2021"
              :categoria "Educação"
              :valor 254
              :estabelecimento "Cambly"})

(defn todas-as-compras []
  [compra1, compra2, compra3, compra4, compra5, compra6, compra7])

(defn usuario []
  {:cadastro cliente
   :cartao   cartao
   :compras  (todas-as-compras)})

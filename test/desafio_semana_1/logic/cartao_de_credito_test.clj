(ns desafio-semana-1.logic.cartao-de-credito-test
  (:require [clojure.test :refer :all]
            [desafio-semana-1.logic.aux.compras :as aux.compras])
  (:require [desafio-semana-1.logic.cartao-de-credito :refer [nova-compra
                                                              valor-total-compras
                                                              valor-total-por-categoria
                                                              lista-de-compras]]
            [desafio-semana-1.logic.db :as l.db]))

;deveria criar outro
;deveria usar schemas
(def usuario (l.db/usuario))

(deftest nova-compra-test
  (let [compra-teste {:data            "24/01/2018"
                      :categoria       "Viagem"
                      :valor           899
                      :estabelecimento "Latam Airlines"}]

    (nova-compra usuario compra-teste)
    (nu/tap usuario)
    (is (= (get usuario :compras)
           (conj aux.compras/lista-de-compras compra-teste)))))

(deftest lista-de-compras-test
  (testing "Deve retornar as compras do usuário"
    (is (= (lista-de-compras usuario)
           aux.compras/lista-de-compras))))

(deftest valor-total-por-categoria-test
  (testing "Deve retornar o valor total de compras por categoria"
    (is (= (valor-total-por-categoria usuario)
           ["Saúde 464" "Educação 537" "Alimentação 618"]))))

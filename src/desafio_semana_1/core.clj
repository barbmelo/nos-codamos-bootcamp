(ns desafio-semana-1.core
  (:require [desafio-semana-1.logic.db :as l.db]
            [desafio-semana-1.logic.cartao-de-credito :as l.cartao-de-credito]))

(def usuario (l.db/usuario))

(l.cartao-de-credito/valor-total-por-categoria usuario)
(println "----------------------------------------------------------------------")

(l.cartao-de-credito/compras-por-estabelecimento usuario "Cambly")

(println "----------------------------------------------------------------------")

(l.cartao-de-credito/total-fatura-mes usuario "09/01/2021")
(println "----------------------------------------------------------------------")

(println usuario)
(println (l.cartao-de-credito/nova-compra usuario {:data            "24/01/2021"
                                                   :categoria       "Saúde"
                                                   :valor           437
                                                   :estabelecimento "Pague Menos"}))
(println usuario)

(println "----------------------------------------------------------------------")

(println (l.cartao-de-credito/lista-de-compras usuario))
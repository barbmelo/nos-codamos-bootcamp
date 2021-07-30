(ns desafio-semana-1.core
  (:require [desafio-semana-1.logic.db :as l.db]
            [common-core.time :as time]))

(def usuario (l.db/usuario))

(defn valor-total-compras
  [[chave compras]]
  (->> compras
       (map :valor)
       (reduce +)
       (str chave " ")))

(defn valor-total-por-categoria
  [usuario]
  (println "O total por categoria é"
           (->> (get usuario :compras)
                (group-by :categoria)
                (map valor-total-compras))))

(valor-total-por-categoria usuario)
(println "----------------------------------------------------------------------")

;Compras por estabelecimento
(defn compras-por-estabelecimento
  [estabelecimento]
  (println "Compras feitas no estabelecimento" estabelecimento)
  (->> (get usuario :compras)
       (filter #(= (get % :estabelecimento) estabelecimento))
       println))
(compras-por-estabelecimento "Cambly")

(println "----------------------------------------------------------------------")
(defn string-para-date [data]
  (time/string->local-date data "dd/MM/yyyy"))

(defn esta-no-periodo-da-fatura
  [data-da-fatura data-da-compra]
  (let [data-da-fatura (string-para-date data-da-fatura)]
    [data-da-compra (string-para-date data-da-compra)]
    (time/within?
      (time/between (time/minus data-da-fatura (time/months 1))
                    data-da-fatura)
      (time/string->local-date data-da-compra "dd/MM/yyyy"))))

;Valor da fatura no mês
(defn total-fatura-mes
  [usuario data-da-fatura]
  (println "O total da fatura do mês sendo a data da expiração da fatura" data-da-fatura "é")
  (->> (get usuario :compras)
       (filter #(esta-no-periodo-da-fatura data-da-fatura (get % :data)))
       (map :valor)
       (reduce +)
       println))
(total-fatura-mes usuario "09/01/2021")
(println "----------------------------------------------------------------------")

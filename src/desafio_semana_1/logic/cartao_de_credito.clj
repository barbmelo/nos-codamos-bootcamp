(ns desafio-semana-1.logic.cartao-de-credito
  (:require [common-core.time :as time]))

(defn valor-total-compras
  [[chave compras]]
  (->> compras
       (map :valor)
       (reduce +)
       (str chave " ")))

(defn valor-total-por-categoria
  [usuario]
  (->> (get usuario :compras)
       (group-by :categoria)
       (map valor-total-compras)))

;Compras por estabelecimento
(defn compras-por-estabelecimento
  [usuario estabelecimento]
  (println "Compras feitas no estabelecimento" estabelecimento)
  (->> (get usuario :compras)
       (filter #(= (get % :estabelecimento) estabelecimento))
       println))

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

;Adicionar uma compra na lista de compras
(defn nova-compra
  [usuario compra]
  (println compra)
  (println "lalala" (def usuario
                      {:cadastro (get usuario :cadastro)
                       :cartao   (get usuario :cartao)
                       :compras  (conj (get usuario :compras) compra)}))
  (println usuario))

;Lista de compras
(defn lista-de-compras
  [usuario]
  (get usuario :compras))
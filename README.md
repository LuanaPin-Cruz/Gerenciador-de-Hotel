# 🏨 Sistema de Gerenciamento de Hotel

📚 Projeto desenvolvido para a disciplina de Programação Orientada a Objetos II (POO II)

---

## 🎯 Objetivo

Desenvolver um sistema de gerenciamento de hotel utilizando **apenas conceitos básicos de programação**, como:

- Vetores
- Matrizes
- Tipos primitivos
- String

❌ Sem uso de:
- ArrayList
- Coleções prontas
- Banco de Dados

---

## 👥 Integrantes

- Luana Pinheiro Cruz  
- Nicollas de Souza Vicente
- Vinícius Alendes

---

## ⚙️ Funcionalidades

O sistema simula o controle de um hotel, permitindo:

### 🛎️ Reservas
- Realizar reserva de quarto
- Cancelar reserva
- Listar quartos ocupados

### 👤 Hóspedes
- Consultar dados do hóspede
- Editar informações do hóspede

### 🧃 Frigobar
- Registrar consumo de produtos
- Consultar consumo por quarto
- Calcular valor total consumido

### 💳 Check-out
- Cálculo de diárias
- Cálculo do consumo do frigobar
- Exibição do resumo da conta
- Liberação do quarto

---

## 🧠 Estrutura do Sistema

### 📌 Hóspedes (Vetor)
Armazena:
- Nome do hóspede
- Número da reserva
- Número do quarto

---

### 🚪 Quartos (Vetor)
- Número do quarto (1 a 100)
- Status:
  - `true` → Ocupado
  - `false` → Disponível

---

### 🧃 Consumo do Frigobar (Matriz)

- Linhas → Quartos  
- Colunas → Produtos:

| Código | Produto        |
|--------|--------------|
| 1      | Água         |
| 2      | Refrigerante |
| 3      | Suco         |
| 4      | Chocolate    |

Cada posição da matriz armazena a quantidade consumida.

---

## 🔄 Operações do Sistema

1. Reservar quarto  
2. Cancelar reserva  
3. Listar reservas  
4. Consultar hóspede  
5. Editar hóspede  
6. Registrar consumo do frigobar  
7. Realizar check-out  

---

## 💻 Como funciona

O sistema utiliza um **menu interativo no console**, permitindo ao usuário escolher as operações através de repetição (loop).

---

## ⚠️ Regras do Projeto

- Máximo de 100 quartos
- Dados armazenados apenas em vetores e matrizes
- Não utilizar estruturas avançadas
- Projeto desenvolvido em grupo

---

## 🚀 Aprendizados

Com este projeto foi possível praticar:

- Lógica de programação
- Manipulação de vetores e matrizes
- Estruturas condicionais e de repetição
- Organização de sistemas simples
- Simulação de problemas reais

---

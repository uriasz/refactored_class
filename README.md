# BetGame - Simulador de Apostas

## Visão Geral
A classe `BetGame` é um simulador de apostas inspirado em loterias, onde o jogador escolhe números dentro de um intervalo e tenta acertar os números sorteados. O sistema valida as apostas, gera números aleatórios para o sorteio e calcula o prêmio com base no número de acertos.

## Funcionalidades
- **Validação de entrada**: Garante que os números da aposta sejam válidos, sem repetições e dentro do intervalo permitido.
- **Geração de números aleatórios**: Cria uma lista de números aleatórios para o sorteio.
- **Cálculo de prêmios**: Define os ganhos do jogador com base nos acertos.
- **Tratamento de exceções**: Erros como números fora do intervalo ou repetições são tratados com mensagens explicativas.

## Estrutura da Classe
### 1. **Validação de Entrada**
- `isNumberValid(int number)`: Verifica se o número está entre 1 e 60.
- `isListSizeValid(List<Integer> list)`: Confirma que a lista tem entre 6 e 15 números.
- `createValidInputList(List<Integer> originalList)`: Filtra e valida a lista de entrada, lançando exceções em caso de erro.

### 2. **Geração de Números Aleatórios**
- `createRandomList()`: Gera uma lista de 6 números aleatórios sem repetição.

### 3. **Cálculo do Prêmio**
- `calculatePrize(List<Integer> inputList, List<Integer> randomList, double givenCash)`: Calcula o valor do prêmio com base nos acertos.

### 4. **Execução da Aposta**
- `apostar(List<Integer> inputList, double givenCash)`: Processa a aposta e retorna o prêmio ou um erro caso a entrada seja inválida.

## Testes Unitários
A classe `BetGameTest` contém testes usando JUnit 5 para garantir que a lógica da aplicação funciona corretamente. Os principais testes incluem:

### **1. Testes de Validação de Entrada**
- `testValidInputList()`: Verifica se uma lista válida de números é aceita sem erros.
- `testInvalidNumberInList()`: Testa se números fora do intervalo permitido geram uma exceção.
- `testDuplicateNumbers()`: Garante que números duplicados na aposta disparam um erro.
- `testSmallBetSize()`: Confirma que listas com menos de 6 números são rejeitadas.
- `testLargeBetSize()`: Confirma que listas com mais de 15 números são rejeitadas.

### **2. Testes da Geração de Números Aleatórios**
- `testRandomListSize()`: Garante que a lista gerada tem exatamente 6 números.

### **3. Testes de Cálculo de Prêmios**
- `testCalculatePrize()`: Simula um caso onde o jogador acerta todos os números e recebe o prêmio total.
- `testNoWinningNumbers()`: Verifica o caso onde nenhum número da aposta é sorteado e o prêmio é zero.

## Como Rodar os Testes
Para executar os testes, use o seguinte comando no terminal:
```sh
mvn test
```
Caso esteja usando uma IDE como IntelliJ IDEA ou Eclipse, basta rodar a classe `BetGameTest` diretamente.

## Conclusão
A classe `BetGame` fornece um simulador de apostas simples e eficaz, garantindo regras justas e tratamento adequado de erros. Os testes unitários cobrem as principais funcionalidades, garantindo confiabilidade no código. 🚀


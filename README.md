
Este repositório contém as implementações das questões propostas, organizadas em subdiretórios dentro da pasta Teste.
Cada questão demonstra diferentes abordagens de comunicação entre processos em Java, utilizando streams, sockets TCP e manipulação de arquivos.

Teste/  
├── questao_1/       # Modelo de compra online e presencial  
├── questao_2/       # Implementações de OutputStream  
├── questao_3/       # Implementações de InputStream  
└── questao_4/       # Implementações de um serviço remoto  

comandos para cada questão pelo terminal:
1 -> 
``` | 
java -cp bin Testes.questao_1.Test  
``` 
2 -> 
System_Out:
``` |
  java -cp bin Testes.questao_2.TesteSystemOut
```
File:
``` | 
  java -cp bin Testes.questao_2.TesteArquivo
```
TCP:
``` |
  java -cp bin Testes.questao_2.TesteServidorTCP
  java -cp bin ServidorTCP 
  ```
3 -> 
   System_in:
  
   ``` |
    java -cp bin Testes.questao_3.TesteSystemIn < dados.bin
  ```
  File:
  ``` |
  java -cp bin Testes.questao_3.TesteArquivo < dados.bin
  ```
  TCP:
  ``` |
  java -cp bin Testes.questao_3.TesteServidorTCP < dados.bin  
  java -cp bin Testes.questao_3.ServidorTCP
  ```
4 -> 
``` |
    java -cp bin Testes.questao_4.ClienteRemoto  
    java -cp bin Testes.questao_3.ServidorRemoto  
``` 

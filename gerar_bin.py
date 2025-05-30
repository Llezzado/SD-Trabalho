import struct

pecas = [
    "Motor;M001;V8;1000.0;450.0",
    "Pneu;P001;Aro18;300.0;18",
    "Pneu;P002;Aro17;280.0;17",
    "Pneu;P003;Aro16;260.0;16",
    "Pneu;P004;Aro15;240.0;15",
    "Amortecedor;A001;Dianteiro;200.0;24",
    "Amortecedor;A002;Traseiro;210.0;30"
]

with open("pecas.bin", "wb") as f:
    f.write(struct.pack(">I", len(pecas)))  # número de peças
    for peca in pecas:
        dados = peca.encode("utf-8")
        f.write(struct.pack(">I", len(dados)))  # tamanho da string
        f.write(dados)
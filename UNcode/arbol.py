
def extractList(linea):
    listaArbol = []
    buffer = ""
    listaStr =  ""
    string = linea

    for i in range(len(string)):
        if (string[i].isnumeric()):
            listaStr += string[i]
        elif (string[i] == "," or string[i] == ":"):
            listaStr += ","


    for n in range(len(listaStr)):
        if (listaStr[n] != ","):
            buffer += listaStr[n]
        else:
            listaArbol.append(int(buffer))
            buffer = ""
    listaArbol.append(int(buffer))
    return(listaArbol)

arbol = input("arbol: ")
listaArbol = extractList(arbol)
    

listaArbol.sort()

intervalo = input("intervalo: ")
listaIntervalo = extractList(intervalo)
print(listaIntervalo)

sum = 0
for j in range(len(listaArbol)):
    if (listaArbol[j] >= listaIntervalo[0] and listaArbol[j] <= listaIntervalo[1]):
        sum += listaArbol[j]
print(sum)

    
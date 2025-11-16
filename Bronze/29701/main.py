codes = input().split()
result = []

for code in codes:
    match code:
        case ".-":
            result.append("A")
        case "-...":
            result.append("B")
        case "-.-.":
            result.append("C")
        case "-..":
            result.append("D")
        case ".":
            result.append("E")
        case "..-.":
            result.append("F")
        case "--.":
            result.append("G")
        case "....":
            result.append("H")
        case "..":
            result.append("I")
        case ".---":
            result.append("J")
        case ""

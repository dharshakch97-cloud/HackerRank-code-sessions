def solve(lines):
    line = lines
    notes = ['C', 'C#', 'D', 'D#', 'E', 'F', 'F#', 'G', 'G#', 'A', 'A#', 'B']
    majors = []
    tones = [2, 2, 1, 2, 2, 2, 1]
    for n in notes:
        row = []
        p = notes.index(n)
        for t in tones:
            row.append(notes[p])
            p += t
            p %= len(notes)
        majors.append(row)

    results = []
    for m in majors:
        flag = True
        for n in line:
            if n not in m:
                flag = False
                break
        if flag:
            results.append(m[0])

    return ' '.join(results)
while True :
    lines = list()
    try :
        lines = input().split()
    except EOFError :
        break
    print(solve(lines))
    
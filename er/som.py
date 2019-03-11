if __name__ == "__main__":
    with open('maze.tex', 'r') as f:
        for line in f.readlines():
            line.split('--').split(',')

class job:
    def __init__(self, shoe_id, time, fine):
        self.shoe_id = shoe_id
        self.time = time
        self.fine = fine

    def __lt__(self, that):
        return self.time * that.fine < that.time * self.fine

    def __repr__(self):
        return str(self.shoe_id)

if __name__ == '__main__':
    tc = int(input())
    input()        
    for i in range(tc):
        jobs = []
        n = int(input())
        for j in range(n):
            job_fines = [int(k) for k in input().split()]
            jobs.append(job(1 + j, job_fines[0], job_fines[1]))
        print(' '.join([str(e) for e in sorted(jobs)]) + "\n")
        try :
            input()
        except EOFError :
            break

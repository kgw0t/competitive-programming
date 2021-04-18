package main

import (
	"fmt"
	"sort"
)

type Pair struct {
	x, h int
}

type Pairs []Pair

func (p Pairs) Len() int {
	return len(p)
}

func (p Pairs) Less(i, j int) bool {
	return p[i].x < p[j].x
}

func (p Pairs) Swap(i, j int) {
	p[i], p[j] = p[j], p[i]
}

func main() {
	var N, D, A int
	fmt.Scan(&N, &D, &A)

	P := make(Pairs, N)
	for i := 0; i < N; i++ {
		var x, h int
		fmt.Scan(&x, &h)
		P[i] = Pair{x, h}
	}

	sort.Sort(Pairs(P))

	count := 0
	for i := 0; i < N; i++ {
		if P[i].h <= 0 {
			continue
		}

		bomb := P[i].x + D
		throw := P[i].h / A
		if P[i].h%A != 0 {
			throw++
		}

		dmg := throw * A
		for j := i + 1; j < N; j++ {
			if bomb+D < P[j].x {
				break
			}
			P[j].h -= dmg
		}

		count += throw
	}

	fmt.Println(count)
}

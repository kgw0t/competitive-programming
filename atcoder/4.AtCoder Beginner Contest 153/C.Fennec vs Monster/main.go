package main

import (
	"fmt"
	"sort"
)

func main() {
	var N, K int
	fmt.Scan(&N, &K)

	var H []int
	for range make([]int, N) {
		var h int
		fmt.Scan(&h)
		H = append(H, h)
	}

	if N <= K {
		fmt.Println(0)
		return
	}

	sort.Sort(sort.IntSlice(H))
	H = H[:N-K]

	sum := 0
	for _, h := range H {
		sum += h
	}
	fmt.Println(sum)
}

package main

import (
	"fmt"
	"sort"
)

func main() {
	var N, K int
	fmt.Scan(&N, &K)

	A := make([]int, N)
	for i, _ := range A {
		fmt.Scan(&A[i])
	}

	R := make([]int, 0)
	for i := 0; i < N-1; i++ {
		for j := i + 1; j < N; j++ {
			R = append(R, A[i]*A[j])
		}
	}
	sort.Ints(R)
	fmt.Println(R[K-1])
}

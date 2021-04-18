package main

import (
	"fmt"
)

func main() {
	var H, N int
	fmt.Scan(&H, &N)

	var A, B []int
	maxEffectA := 0
	maxEffectB := 0
	maxEffect := 0.0
	for range make([]int, N) {
		var a, b int
		fmt.Scan(&a, &b)
		A = append(A, a)
		B = append(B, b)

		effect := float64(a) / float64(b)
		fmt.Println(effect)
		if maxEffect < effect {
			maxEffect = effect
			maxEffectA = a
			maxEffectB = b
		}
	}

	modH := H % maxEffectA
	useMP := (H / maxEffectA) * maxEffectB
	if modH == 0 {
		fmt.Println(useMP)
		return
	}

	minLastB := 10001
	for i, _ := range make([]int, N) {
		a := A[i]
		b := B[i]

		if modH <= a && b < minLastB {
			minLastB = b
		}
	}

	fmt.Println(useMP + minLastB)

}

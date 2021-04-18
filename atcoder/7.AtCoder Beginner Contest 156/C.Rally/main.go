package main

import (
	"fmt"
	"math"
)

func round(f float64) float64 {
	return math.Floor(f + .5)
}

func main() {
	var N int
	fmt.Scan(&N)

	X := make([]int, N)
	sum := 0
	for i, _ := range X {
		fmt.Scan(&X[i])
		sum += X[i]
	}

	avg := int(round(float64(sum) / float64(N)))

	result := 0
	for _, x := range X {
		result += (x - avg) * (x - avg)
	}

	fmt.Println(result)
}

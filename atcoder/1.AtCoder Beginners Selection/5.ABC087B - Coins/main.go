package main

import (
	"fmt"
)

func main() {
	var A, B, C, X int
	fmt.Scan(&A, &B, &C, &X)

	count := 0

	for a := 0; a <= A; a++ {
		priceA := 500 * a

		if priceA == X {
			count++
			break
		} else if X < priceA {
			break
		}

		for b := 0; b <= B; b++ {
			priceB := priceA + 100*b

			if priceB == X {
				count++
				break
			} else if X < priceB {
				break
			}

			if (X-priceB)/50 <= C {
				count++
			}
		}
	}
	fmt.Println(count)
}

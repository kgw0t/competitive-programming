package main

import (
	"fmt"
)

func main() {
	var S, T string
	fmt.Scan(&S, &T)

	var A, B int
	fmt.Scan(&A, &B)

	var U string
	fmt.Scan(&U)

	if S == U {
		fmt.Println(A - 1, B)
	} else {
		fmt.Println(A, B - 1)
	}
}

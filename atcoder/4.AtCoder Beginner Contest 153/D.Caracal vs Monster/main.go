package main

import (
	"fmt"
)

func main() {
	var H int
	fmt.Scan(&H)

	count := 1
	for H > 1 {
		H = H / 2
		count = count*2 + 1
	}

	fmt.Println(count)
}

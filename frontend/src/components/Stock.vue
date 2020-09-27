<template>
    <b-card 
    
    header="Add Order"
    style="max-width: 30rem;  "
    header-text-variant="white"

    header-bg-variant="primary"
   
   
  >

   <b-table
      id="table-transition-example"
      :items="items"
      :fields="fields"
      striped
      small
      primary-key="a"
      :tbody-transition-props="transProps"
    ></b-table>
    <p></p>
     <b-row align-h="center">
              
                <b-button 
                onclick="RegisterCustomer"
                variant="success">SAVE
                  
                </b-button>
                
           
                <b-button 
               @click="clear()"
              
                variant="danger">CLEAR</b-button>
              
                <b-button 
                @click="Back"
                variant="primary">BACK</b-button>
            
            </b-row>
            



  </b-card>

    
</template>

<script>
  export default {
    data() {
      return {
        transProps: {
          // Transition name
          name: 'flip-list'
        },
        items: [
          { a: 2, b: 'Two', c: 'Moose' },
          { a: 1, b: 'Three', c: 'Dog' },
          { a: 3, b: 'Four', c: 'Cat' },
          { a: 4, b: 'One', c: 'Mouse' },
          { a: 2, b: 'Two', c: 'Moose' },
          { a: 1, b: 'Three', c: 'Dog' },
          { a: 3, b: 'Four', c: 'Cat' },
          { a: 4, b: 'One', c: 'Mouse' }
        ],
        fields: [
          { key: 'a', sortable: true },
          { key: 'b', sortable: true },
          { key: 'c', sortable: true }
        ]
      }
    }
  }
</script>


import { describe, it, expect, vi } from 'vitest'

import { shallowMount, flushPromises } from '@vue/test-utils'
import AdminTable from '../AdminTable.vue'
import axios from 'axios'

describe('AdminTable.vue', () => {
  const emptyResponse = []
  const twoItemResponse = [
    { quote: 'Chuck Norris Spruch 1', index: 1 },
    { quote: 'Chuck Norris Spruch 2', index: 2 }
  ]

  vi.mock('axios')

  it('should render the title passed to it', () => {
    axios.get.mockResolvedValueOnce({ data: emptyResponse})

    const title = 'This is a title!'
    const wrapper = shallowMount(AdminTable, {
      props: { title }
    })
    expect(wrapper.text()).toMatch(title)
  })

  it('should render the items from the backend', async () => {
    axios.get.mockResolvedValueOnce({ data: twoItemResponse })

    const item = twoItemResponse[0].quote
    const wrapper = shallowMount(AdminTable)

    await flushPromises()

    const inputElements = wrapper.findAll('input.w-100')
    expect(inputElements[0].element.value).toContain(item)
  })

  it('should save an item to the backend', async () => {
    axios.get.mockResolvedValueOnce({ data: twoItemResponse })
    axios.post.mockResolvedValueOnce({ data: emptyResponse })

    const wrapper = shallowMount(AdminTable)

    const newQuoteText = wrapper.find('#new-quote-text')
    await newQuoteText.setValue('Ein neuer Spruch')
    const saveButton = wrapper.find('#save-button')
    await saveButton.trigger('click')

    expect(axios.post).toHaveBeenCalledWith(
        "http://localhost:8080/api/v1/quote/",
        {
          quote: 'Ein neuer Spruch',
          index: "",
        })
  })

  it('should update a quote in the backend', async () => {
    axios.get.mockResolvedValueOnce({data: twoItemResponse})
    axios.put.mockResolvedValueOnce({data: emptyResponse})


    const index = twoItemResponse[0].index;
    const saveBtnId = `#save-edit`;

    const wrapper = shallowMount(AdminTable)

    await flushPromises()

    expect(wrapper.find(saveBtnId).exists()).toBeFalsy();

    const editButton = wrapper.find(`#edit-button-${index}`)
    await editButton.trigger('click')
    const editInput = wrapper.find(`#edit-input-${index}`)
    await editInput.setValue('Ein neuer Spruch')
    const saveButton = wrapper.find(saveBtnId)
    await saveButton.trigger('click')

    expect(axios.put).toHaveBeenCalledWith(
        "http://localhost:8080/api/v1/quote?index=1",
        { quote: 'Ein neuer Spruch' })
  })
})

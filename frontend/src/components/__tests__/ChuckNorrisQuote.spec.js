import { describe, it, expect } from 'vitest'

import { shallowMount } from '@vue/test-utils'
import Quote from '../ChuckNorrisQuote.vue'

describe('ChuckNorrisQuote.vue', () => {
  it('renders component', () => {
    const msg = 'Chuck Norris';
    const wrapper = shallowMount(Quote);
    expect(wrapper.text()).toContain(msg);
  })
})
